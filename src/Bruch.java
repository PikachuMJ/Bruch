import static javax.swing.JOptionPane.showInputDialog;

@SuppressWarnings("all")
public class Bruch {
    private int zaehler;
    private int nenner = 1;
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }
    public boolean setNenner(int nenner) {
        if (nenner != 0) {
            this.nenner = nenner;
            return true;
        } else
            return false;
    }
    public int getZaehler() {
        return zaehler;
    }
    public int getNenner() {
        return nenner;
    }
    public void kuerze() {
        // Größten gemeinsamen Teiler mit dem euklidischen Algorithmus bestimmen
        if (zaehler != 0) {
            int gespeicherterZaehler = Math.abs(zaehler);
            int gespeicherterNenner = Math.abs(nenner);
            while (gespeicherterZaehler != gespeicherterNenner)
                if (gespeicherterZaehler > gespeicherterNenner)
                    gespeicherterZaehler = gespeicherterZaehler - gespeicherterNenner;
                else
                    gespeicherterNenner = gespeicherterNenner - gespeicherterZaehler;
            zaehler = zaehler / gespeicherterZaehler;
            nenner = nenner / gespeicherterZaehler;
        } else
            nenner = 1;
    }
    public void addiere(Bruch bruch) {
        zaehler = zaehler * bruch.nenner + bruch.zaehler * nenner;
        nenner = nenner * bruch.nenner;
        kuerze();
    }
    public void frage() {
        int nenner = 1;
        boolean isError = false;
        do {
            try {
                isError = false;
                setZaehler(Integer.parseInt(showInputDialog("Zaehler")));
            }catch (Exception e) {
               isError = true;
            }
        } while (isError);
        do {
            try {
                isError = false;
                nenner = Integer.parseInt(showInputDialog("nenner"));
            }catch (Exception e) {
                isError = true;
            }
            if (nenner == 0 && isError) {
                System.out.println("Der Nenner darf nicht null werden!\n");
            }
        } while (nenner == 0 || isError);
        setNenner(nenner);
    }
    public void zeige() {
        System.out.printf(" %d\n -----\n %d\n", zaehler, nenner);
    }
}