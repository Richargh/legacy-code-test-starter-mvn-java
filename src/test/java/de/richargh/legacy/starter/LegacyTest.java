package de.richargh.legacy.starter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LegacyTest {

    @Test
    void regularTest() {
        // given
        var byteStream = new ByteArrayOutputStream();
        var printStream = new PrintStream(byteStream);
        System.setOut(printStream);

        var testee = new Legacy();

        // when
        testee.doSth("foo", true);

        // then
        var result = byteStream.toString();
        assertThat(result).isEqualTo("""
        Setting mode 1
        I am now in mode 1
        You gain
        and
        """);
    }

}
