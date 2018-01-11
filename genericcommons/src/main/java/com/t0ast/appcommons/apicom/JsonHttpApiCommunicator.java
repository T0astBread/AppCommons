package com.t0ast.appcommons.apicom;

import com.google.gson.Gson;
import com.t0ast.appcommons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by T0astBread on 04.01.2018.
 */

public class JsonHttpApiCommunicator
{
    private static Gson gson;

    public JsonHttpApiCommunicator()
    {
        this.gson = new Gson();
    }

    public <T> T request(RequestParams params) throws IOException
    {
        HttpURLConnection connection = (HttpURLConnection) new URL(params.getUrl()).openConnection();
        connection.setRequestMethod(params.getMethod());
        if(params.hasBody())
        {
            if(params.isPrintBody()) System.out.println(params.getBody());
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", params.getBodyMimeType());
            byte[] body = params.getBody().getBytes();
            connection.setFixedLengthStreamingMode(body.length);
            connection.getOutputStream().write(body);
            connection.getOutputStream().flush();
        }

        if(params.hasOutputType())
        {
            String response = IOUtils.readWholeStream(connection.getInputStream());
            if(params.isPrintResponse()) System.out.println(response);
            return gson.fromJson(response, params.getOutputType());
        }
        else return null;
    }

    public static RequestParams createParams()
    {
        return new RequestParams();
    }

    public static class RequestParams
    {
        private String url, method;
        private Type outputType;
        private boolean printResponse;
        private String body, bodyMimeType;
        private boolean printBody;

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public String getMethod()
        {
            return method;
        }

        public void setMethod(String method)
        {
            this.method = method;
        }

        public boolean hasOutputType()
        {
            return this.outputType != null;
        }

        public Type getOutputType()
        {
            return outputType;
        }

        public void setOutputType(Type outputType)
        {
            this.outputType = outputType;
        }

        public boolean isPrintResponse()
        {
            return printResponse;
        }

        public void setPrintResponse(boolean printResponse)
        {
            this.printResponse = printResponse;
        }

        public boolean hasBody()
        {
            return this.body != null;
        }

        public String getBody()
        {
            return body;
        }

        public String getBodyMimeType()
        {
            return bodyMimeType;
        }

        public void setBody(Object body)
        {
            setBody(gson.toJson(body), "application/json");
        }

        public void setBody(String body)
        {
            setBody(body, "text/plain");
        }

        public void setBody(String body, String mimeType)
        {
            this.body = body;
            this.bodyMimeType = mimeType;
        }

        public boolean isPrintBody()
        {
            return printBody;
        }

        public void setPrintBody(boolean printBody)
        {
            this.printBody = printBody;
        }
    }
}
