package streams

import org.junit.Test

class StreamsDemoTest {
    StreamsDemo demo = new StreamsDemo()

    @Test
    void joinStream() throws Exception {
        assert 'this is a list of strings' == demo.joinStream()
    }

    @Test
    void joinUpperCase() throws Exception {
        assert 'THIS IS A LIST OF STRINGS' == demo.joinUpperCase()
    }

    @Test
    void getTotalLength() throws Exception {
        assert demo.totalLength == 20
    }

    @Test
    void sumFirstNBigDecimals() throws Exception {
        assert 55.0d  == demo.sumFirstNBigDecimals(10)
        assert 210.0d == demo.sumFirstNBigDecimals(20)
    }

}