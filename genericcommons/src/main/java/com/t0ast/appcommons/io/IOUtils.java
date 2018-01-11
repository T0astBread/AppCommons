package com.t0ast.appcommons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Michael on 04.12.2017.
 */

public class IOUtils
{
    public static String readWholeStream(InputStream in) throws IOException
    {
        return readWholeStream(new InputStreamReader(in));
    }

    public static String readWholeStream(Reader in) throws IOException
    {
        StringBuilder streamContent = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(in))
        {
            String line = null;
            while(true)
            {
                line = reader.readLine();
                if(line == null) break;
                streamContent.append(line);
            }
        }
        return streamContent.toString();
    }
}
