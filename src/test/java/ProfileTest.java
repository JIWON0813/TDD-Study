import chapter2.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @BeforeEach
    public void create(){
        Profile profile = new Profile("Bull Hockey");
        Question question = new BooleanQuestion(1, "Got bonuses?");
        Criteria criteria = new Criteria();
    }


    @Test
    public void matchAnwsersFalseWhenMustMatchCriteriaNotMet(){
        profile.add(new Answer(question, Bool.FALSE));
        Criterion criterion = new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch);

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }

    @Test
    public void matchAnwsersFalseWhenMustMatchCriteria(){
        profile.add(new Answer(question, Bool.FALSE));
        Criterion criterion = new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare);

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }
}