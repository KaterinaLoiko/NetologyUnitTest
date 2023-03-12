import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class TestData {
  public static Stream<Arguments> contacts() {
    return Stream.of(
        Arguments.of(new Contact("Муж", "86746750453"), "86746750453"),
        Arguments.of(new Contact("Иван Петрович", "89746750423"), "89746750423"),
        Arguments.of(new Contact("Мама", "86747850453"), "86747850453")
    );
  }

  public static Stream<Arguments> contactsInGroup() {
    return Stream.of(
        Arguments.of(new Contact("Муж", "86746750453"), "Семья"),
        Arguments.of(new Contact("Иван Петрович", "89746750423"), "Работа"),
        Arguments.of(new Contact("Мама", "86747850453"), "Семья")
    );
  }
}
