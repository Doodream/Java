public class Person {
    private String name;
    private int age;
    private int cashAmount;
    // 은행 계좌
    private BankAccount account;

    // 클래스 생성자 인수 : 이름, 나이
    public Person(String pName, int pAge) {
        name = pName;
        if (age < 0) {
            age = 12;
        } else {
            age = pAge;
        }
        // 현금은 기본 0원
        cashAmount = 0;
    }
    @Override
    public String toString(){
        return "toString 오버라이드 성공";
    }

    // 클래스 생성자 오버로딩 인수 : 이름, 나이, 현금
    public Person(String pName, int pAge, int pCashAmount) {
        name = pName;
        if (age < 0) {
            age = 12;
        } else {
            age = pAge;
        }
        if (pCashAmount < 0) {
            cashAmount = 0;
        } else {
            cashAmount = pCashAmount;
        }
    }
    // 이름 setter 메소드
    public void set_name(String new_name) {
        name = new_name;
    }

    // 이름 getter 메소드
    public String get_name() {
        return name;
    }

    // 현금 setter 메소드
    public void set_cash(int new_cash) {
        if (new_cash > 0) {
            cashAmount = new_cash;
        }
    }

    // 현금 getter 메소드
    public int get_cash() {
        return cashAmount;
    }

    // 계좌 setter
    public void set_account(BankAccount new_account) {
        account = new_account;
    }

    // 계좌 getter
    public BankAccount get_account() {
        return account;
    }

    // 계좌 송금 인수 : 수금자, 송금액
    boolean transfer(Person person, int amount) {
        // 송금액이 0보다 작거나 송금자의 계좌잔액보다 큰경우 송금 실패
        if (amount < 0 || amount > account.get_balance()) {
            System.out.println(false + " - from: " + get_name() + ", to: " + person.get_name() + ", amount: " + amount + ", balance: " + account.get_balance());
            return false;
            // 송금을 성공하면 소유주 계좌의 잔액에서 송금액을 빼고, 수금자의 계좌잔액을 송금액만큼 늘린다.
        } else {
            account.set_balance(account.get_balance() - amount);
            person.get_account().set_balance(person.get_account().get_balance() + amount);
            System.out.println(true + " - from: " + get_name() + ", to: " + person.get_name() + ", amount: " + amount + ", balance: " + account.get_balance());
            return true;
        }
    }
    // 계좌 송금 인수 : 수금자, 송금액
    boolean transfer(BankAccount Account, int amount) {
        // 송금액이 0보다 작거나 송금자의 계좌잔액보다 큰경우 송금 실패
        if (amount < 0 || amount > account.get_balance()) {
            System.out.println(false + " - from: " + get_name() + ", to: " + Account.get_person() + ", amount: " + amount + ", balance: " + account.get_balance());
            return false;
            // 송금을 성공하면 소유주 계좌의 잔액에서 송금액을 빼고, 수금자의 계좌에서 계좌잔액을 송금액만큼 늘린다.
        } else {
            account.set_balance(account.get_balance() - amount);
            Account.set_balance(Account.get_balance() + amount);
            System.out.println(true + " - from: " + get_name() + ", to: " + Account.get_person() + ", amount: " + amount + ", balance: " + account.get_balance());
            return true;
        }
    }
}