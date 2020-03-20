import java.io.IOException;

public class IssueParserTest {


    public static void main(String[] args) throws IOException {
        String inputDir = "./Origin_Issues/zookeeper";
        String output = "./perf_issues";
        String[] arguments = {inputDir,output};
        IssueParser.main(new String[] {});
        IssueParser.main(arguments);
    }
}
