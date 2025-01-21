package karas.dominik.fitnesstracker.common.user.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import karas.dominik.fitnesstracker.common.user.UserId;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserIdSerializer extends StdSerializer<UserId> {

    public UserIdSerializer() {
        super(UserId.class);
    }

    @Override
    public void serialize(UserId userId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(userId.toString());
    }
}
