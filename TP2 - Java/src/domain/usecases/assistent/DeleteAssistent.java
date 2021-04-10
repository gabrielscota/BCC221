package domain.usecases.assistent;

import domain.entities.Clinic;

public interface DeleteAssistent {
    void deleteAssistent(Clinic clinic, String id);
}
