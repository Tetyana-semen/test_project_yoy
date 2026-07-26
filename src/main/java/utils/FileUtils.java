package utils;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;
import static java.nio.charset.Charset.defaultCharset;
import static java.util.Objects.nonNull;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import lombok.SneakyThrows;

public class FileUtils {

    @SneakyThrows
    public static String readFromFileNamed(String... pathParts) {
        String path = String.join("", pathParts);
        URL resource = FileUtils.class.getClassLoader().getResource(path);
        checkArgument(nonNull(resource), format("File not found: %s", path));
        File file = new File(resource.getFile());
        return Files.readString(file.toPath(), defaultCharset());
    }

}
