package de.richargh.legacy.starter;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class LegacyApprovalTest {

    @Test
    void testWithApprovalTests() {
        CombinationApprovals.verifyAllCombinations(
                this::runWithResult,
                new String[]{"1"},
                new Boolean[]{true, false});
    }

    private String runWithResult(String tmp, boolean flag){
        try(var byteStream = new ByteArrayOutputStream(); var printStream = new PrintStream(byteStream)){
            System.setOut(printStream);
            run(tmp, flag);
            return byteStream.toString();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    private static void run(String tmp, boolean flag) {
        Legacy.rand.setSeed(123);
        var testee = new Legacy();
        testee.doSth(tmp, flag);
    }
}
