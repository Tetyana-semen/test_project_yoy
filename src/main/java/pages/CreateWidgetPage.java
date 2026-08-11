package pages;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateWidgetPage {

    private static final Path OUTPUT_DIRECTORY =
        Path.of("outputs").toAbsolutePath();

    public static Path create(String eventId) throws IOException {

        Files.createDirectories(OUTPUT_DIRECTORY);

        String html = """
            <!doctype html>
            <html lang="uk">
              <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>YOY Widget Test</title>
              </head>
              <body>
                <h1>Реєстрація на подію</h1>
            
                <div
                  data-yoy-event="%s"
                  data-yoy-theme="auto">
                </div>
            
                <script src="https://embed.test.yoy.events/v1.js" async></script>
              </body>
            </html>
            """.formatted(eventId);

        Path output = OUTPUT_DIRECTORY.resolve("embed-widget-landing.html");

        Files.writeString(
            output,
            html,
            StandardCharsets.UTF_8
        );

        return output;
    }
}
