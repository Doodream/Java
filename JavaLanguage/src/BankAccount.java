public class BankAccount {
    private int balance;
    private Person owner;

    // 은행 계좌 생성자 잔액
    public BankAccount(int pBalance){
        // 잔액이 0 이하로 주어질 때는 balance를 0으로
        if (pBalance < 0){
            balance = 0;
        }
        else{
            balance = pBalance;
        }
    }

    // 은행계좌 생성자 오버로딩 Person
    public BankAccount(Person pOwner){
        owner = pOwner;
        balance = balance;
    }

    // 은행계좌 생성자 오버로딩 잔액, Person
    public BankAccount(int pBalance, Person pOwner){
        if (pBalance < 0){
            balance = 0;
        }
        else{
            balance = pBalance;
        }

        owner = pOwner;
    }
    // Person name의 setter 메소드
    public void set_person(Person new_person) {
        owner = new_person;
    }

    // Person의 name의 getter 메소드
    public String get_person() {
        return owner.get_name();
    }

    // 은행계좌 잔액의 setter 메소드
    public void set_balance(int new_balance) {
        if (new_balance > 0) {
            balance = new_balance;
        }
    }

    // 은행계좌 잔액의 getter 메소드
    public int get_balance() {
        return balance;
    }


    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    // 계좌에 넣을 입금 메소드
    boolean deposit(int amount) {
        // 입금액이 0보다 작거나 계좌주의 현금보다 입금액이 클 경우는 입금 실패
        // 입금이 실패할 경우는 입금되지 않는다.
        if (amount < 0 || owner.get_cash() < amount) {
            System.out.println("입금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.get_cash() + "원");
            return false;
            // 나머지 경우는 입금 성공
            // 입금이 성공할 경우에는 계좌잔액에 입금액을 더하고 소유주의 현금액은 입금액 만큼 줄어든다.
        } else {
            balance += amount;
            owner.set_cash(owner.get_cash() - amount);
            System.out.println(amount + "원 입금하였습니다. 잔고: " + balance + "원, 현금: " + owner.get_cash() + "원");

            return true;

        }

    }

    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    // 소유주의 계좌에서 출금하는 메소드
    boolean withdraw(int amount) {
        // 출금액이 0보다 작거나 계좌의 잔액보다 출금액이 크면 출금 실패
        // 출금이 실패할 경우 금액 변동 없음.
        if (amount < 0 || balance < amount) {
            System.out.println("출금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.get_cash() + "원");

            return false;
            // 출금에 성공할 경우 소유주 현금이 출금액 만큼 늘고, 계좌 잔액은 출금액 만큼 준다.
        } else {
            owner.set_cash(owner.get_cash() + amount);
            balance -= amount;
            System.out.println(amount + "원 출금하였습니다. 잔고: " + balance + "원, 현금: " + owner.get_cash() + "원");

            return true;
        }

    }

    // 계좌이체 인수: (은행 계좌, 송금액)
    boolean transfer(BankAccount account, int amount) {
        // 송금액이 음수거나 계좌 잔액보다 클 경우 송금 실패.
        if (amount < 0 || amount > get_balance()) {
            System.out.println(false + " - from: " + owner.get_name() + ", to: " + account.owner.get_name() + ", amount: " + amount + ", balance: " + get_balance());
            return false;
            // 송금성공일 경우 현계좌의 잔액에서 송금액을 줄이고 보낸 계좌의 잔액을 늘린다.
        } else {
            set_balance(get_balance() - amount);
            account.set_balance(account.get_balance() + amount);
            System.out.println(true + " - from: " + owner.get_name() + ", to: " + account.owner.get_name() + ", amount: " + amount + ", balance: " + get_balance());
            return true;
        }
    }
    // 계좌이체 오버로딩 인수: (받는 사람, 송금액)
    boolean transfer(Person person, int amount) {
        // 송금액이 음수거나 계좌 잔액보다 클 경우 송금 실패.
        if (amount < 0 || amount > get_balance()) {
            System.out.println(false + " - from: " + owner.get_name() + ", to: " + person.get_name() + ", amount: " + amount + ", balance: " + get_balance());
            return false;
            // 송금성공일 경우 현계좌의 잔액에서 송금액을 줄이고 보낸 사람의 계좌잔액을 늘린다.
        } else {
            set_balance(get_balance() - amount);
            person.get_account().set_balance(person.get_account().get_balance() + amount);
            System.out.println(true + " - from: " + owner.get_name() + ", to: " + person.get_name() + ", amount: " + amount + ", balance: " + get_balance());
            return true;
        }
    }

}