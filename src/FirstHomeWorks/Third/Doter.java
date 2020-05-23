public class Doter implements Comparable<Doter>{
    private Integer hoursInGame;

    private Integer getHoursInGame(){
        return hoursInGame;
    }

    @Override
    public int compareTo(Doter o) {
        return this.getHoursInGame().compareTo(o.getHoursInGame());
    }
}
