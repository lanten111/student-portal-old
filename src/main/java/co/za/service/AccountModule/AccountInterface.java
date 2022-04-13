package co.za.service.AccountModule;

public interface AccountInterface {

    public void getAccount(String studentId);

    void getAccountStatement(String studentId);

    void uploadPaymentProof(String studentId);
}
