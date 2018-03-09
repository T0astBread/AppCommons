package cc.t0ast.androidcommons.json;

import com.annimon.stream.function.Function;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by T0astBread on 21.01.2018.
 */

public class JsonUtils
{
    public static <T> T[] toArray(JSONArray jsonArray, Function<Integer, T[]> arrayProducer) throws JSONException
    {
        T[] arr = arrayProducer.apply(jsonArray.length());
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = (T) jsonArray.get(i);
        }
        return arr;
    }
}
