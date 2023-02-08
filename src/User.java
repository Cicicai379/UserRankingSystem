public class User {
    private int progress;
    private int rank;

    public User(){
        this.rank=-8;
        this.progress=0;
    }

    public int getProgress() {
        return progress;
    }

    public int getRank() {
        return rank;
    }
    public void incProgress(int r){
        if(r<-8 ||r>8||r==0){ //illegal argument
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if(r==rank){ //same rank
            progress+=3;
        }else if(r<rank-1 &&!(rank>0 && r<0)){ //more than 2 smaller than  rank
            progress+=0;
        }else if(r<rank){ //less than rank but not more than 2 less
            progress+=1;
        }else{ //other condition
            if(rank<0 && r>0){ //when rank 0 dosen't count
                r-=1;
            }
            r = r-this.rank;
            this.progress+=r*r*10;

        }

        while(progress>=100){

            progress-=100;
            rank+=1;
            if(rank==0) rank+=1;
        }

    }


    public String toString() {
        return "User{" + "rank=" + this.rank + ", progress=" + this.progress + '}';
    }
}
