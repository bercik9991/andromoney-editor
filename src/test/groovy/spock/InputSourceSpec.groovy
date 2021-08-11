package spock

import org.apache.commons.lang3.StringUtils
import org.mozilla.universalchardet.UniversalDetector
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 *
 */
class InputSourceSpec extends Specification {



    def 'should detect input charset'() {
        given:
            Path path = Paths.get("src/test/resources/inputSource.csv")
            byte[] inputByteArray = Files.readAllBytes(path)
            UniversalDetector detector = new UniversalDetector()
            detector.handleData(inputByteArray)
            String charsetName = detector.getDetectedCharset()

        expect:
            verifyAll {
                inputByteArray.length > 0
                StringUtils.isNotBlank(charsetName)
            }
    }
}
