import chapter2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    public void matchAnwsersFalseWhenMustMatchCriteriaNotMet(){
        Profile profile = new Profile("Bull Hockey");
        Question question = new BooleanQuestion(1, "Got bonuses?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
        Answer answer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(answer, Weight.DontCare);

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }
}