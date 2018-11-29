package com.botpy.digiccy.api.parser;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * 用于动态解析，数据处理
 * @author liuxuhui
 * @date 2018/11/18
 */
public class SampleParser<T> implements JsonDeserializer<T> {
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonObject dataObject = jsonObject.getAsJsonObject("data");
        if (dataObject != null) {
            JsonElement  token = dataObject.get("token");
            JsonObject user = dataObject.getAsJsonObject("user_info");

            user.add("token", token);
            // 整理 user 作为 data 节点数据
            jsonObject.add("data", user);
        }
        return new Gson().fromJson(json, typeOfT);
    }
}
