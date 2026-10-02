public class BusTest {
    public static void main(String[] args) throws Exception {
        Companie c=new Companie("Test",0,0);
        Chauffeur driver=new Chauffeur("Li","A","Adresse","driver",30,2020,0);c.ajouterChauffeur(driver);
        Bus bus=new Bus("abc","bleu",100,30);c.ajouterBus(bus);
        Trajet t=new Trajet("A","B",0,10);c.reserverBus("driver","abc",t);
        if(c.trouverBusConduits("driver").length!=1 || bus.getTrajet()!=t || t.getBusUtilise()!=bus)throw new AssertionError();
        try{c.reserverBus("driver","abc",t);throw new AssertionError();}catch(ErreurException expected){}
        try{c.ajouterBus(bus);throw new AssertionError();}catch(ErreurException expected){}
        try{new Trajet("A","B",100,0);throw new AssertionError();}catch(IllegalArgumentException expected){}
        for(int i=0;i<110;i++){Bus b=new Bus("bus"+i,"bleu",100,30);c.ajouterBus(b);c.reserverBus("driver","bus"+i,new Trajet("A","B",0,10));}
        if(c.trouverBusConduits("driver").length!=111)throw new AssertionError();
        Companie vide=new Companie("Test",1,1);
        vide.setBus(new Bus[0]);vide.setChauffeur(new Chauffeur[0]);vide.ajouterChauffeur(driver);vide.ajouterBus(new Bus("nouveau","bleu",100,30));
        if(vide.trouverChauffeur("driver")!=driver || vide.trouverBus("nouveau")==null)throw new AssertionError();
        driver.setTrajetAssocie(new Trajet[]{null,t});driver.ajouterTrajetAssocie(new Trajet("A","B",0,20));
        if(driver.getTrajetAssocie()[0]!=t)throw new AssertionError();
        System.out.println("Bus : réservation, doublons, validation et capacité OK");
    }
}
