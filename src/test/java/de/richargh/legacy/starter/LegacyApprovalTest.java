package de.richargh.legacy.starter;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LegacyApprovalTest {

    @Test
    void testWithApprovalTests() {
        CombinationApprovals.verifyAllCombinations(
                this::doSth,
                new String[]{"1"},
                new Boolean[]{true, false});
    }

    private String doSth(String tmp, boolean flag){
        var byteStream = new ByteArrayOutputStream();
        var printStream = new PrintStream(byteStream);
        System.setOut(printStream);

        var testee = new Legacy();
        testee.doSth(tmp, flag);

        return byteStream.toString();
    }

}
