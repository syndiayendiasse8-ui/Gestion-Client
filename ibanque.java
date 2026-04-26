package repertoire;

import entite.client;
import entite.compte;
import entite.employer;

public interface ibanque {

    compte scancompte();
    client scanclient();
    employer scanemployer();

    void addcompte();
    void addclient();
    void addemployer();

    void printallclient();
    void printallemployer();
}