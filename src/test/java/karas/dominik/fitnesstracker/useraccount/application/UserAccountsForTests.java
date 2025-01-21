package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.DecodedPassword;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.Email;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserAccountsForTests {

    public static final class BOB {
        public static final UserId ID = UserId.from("0f84ab11-0904-47b6-9b2b-e163be67684f");
        public static final Email EMAIL = Email.of("bob@gmail.com");
        public static final DecodedPassword PASSWORD = DecodedPassword.of("Test1234!");
        public static final UserAccountTestData DATA = new UserAccountTestData(ID, EMAIL, PASSWORD);
    }

    public record UserAccountTestData(UserId userId, Email email, DecodedPassword password) {}
}
