package karas.dominik.fitnesstracker.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TestUtils {

    public static String fetchJsonFrom(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static Map<String, Object> parsed(String json) {
        return new Gson().fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
    }
}
