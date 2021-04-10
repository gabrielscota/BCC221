package domain.usecases.assistent;

import domain.entities.Assistent;
import domain.entities.Clinic;

public interface EditAssistent {
    void editAssistent(Clinic clinic, Assistent newAssistentSpec);
}
