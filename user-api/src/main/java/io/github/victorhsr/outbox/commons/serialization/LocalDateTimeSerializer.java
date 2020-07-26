package io.github.victorhsr.outbox.commons.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private static final long serialVersionUID = 6730660010798182329L;

    public static String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public LocalDateTimeSerializer() {
        this(null);
    }

    public LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LocalDateTimeSerializer.LOCAL_DATE_TIME_FORMAT);
        gen.writeString(value.format(formatter));
    }

}

