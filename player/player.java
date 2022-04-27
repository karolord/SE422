import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class player {
    private String nickname;
    private String ip;
    private String email;
    private ReadWriteLock nicknamelock;
    private ReadWriteLock iplock;
    private ReadWriteLock emaillock;

    public static void main(String[] args) {
        player p1 = new player("yahya", "1.1.1.1", "email");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                p1.getNickname();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                p1.getNickname();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("waiting");
                p1.setNickname("ajdwajida");
                System.out.println("finished");
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                p1.setNickname("aidjwidja");
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public player(String nickname, String ip, String email) {
        this.nickname = nickname;
        this.ip = ip;
        this.email = email;
        this.nicknamelock = new ReentrantReadWriteLock();
        this.iplock = new ReentrantReadWriteLock();
        this.emaillock = new ReentrantReadWriteLock();
    }

    public String getNickname() {
        nicknamelock.readLock().lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return this.nickname;

        } finally {
            nicknamelock.readLock().unlock();
        }
    }

    public void setNickname(String nickname) {
        nicknamelock.writeLock().lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            this.nickname = nickname;

        } finally {
            nicknamelock.writeLock().unlock();
        }
    }

    public String getIp() {
        iplock.readLock().lock();
        try {
            return this.ip;

        } finally {
            iplock.readLock().unlock();
        }
    }

    public void setIp(String ip) {
        iplock.writeLock().lock();
        try {
            this.ip = ip;

        } finally {
            iplock.writeLock().unlock();
        }
    }

    public String getEmail() {
        emaillock.readLock().lock();
        try {
            return this.email;

        } finally {
            emaillock.readLock().unlock();
        }
    }

    public void setEmail(String email) {
        emaillock.writeLock().lock();
        try {
            this.email = email;

        } finally {
            emaillock.writeLock().unlock();
        }
    }

}
