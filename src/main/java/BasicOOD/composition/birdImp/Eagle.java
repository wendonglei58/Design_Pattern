package BasicOOD.composition.birdImp;

import BasicOOD.composition.Flyable;
import BasicOOD.composition.Tweetable;

public class Eagle implements Flyable, Tweetable{
    Flyable flyHigh = new FlyHighAbility();
    Tweetable tweetLow = new TweetLowAbility();


    @Override
    public void fly() {
        flyHigh.fly();
    }

    @Override
    public void tweet() {
        tweetLow.tweet();
    }
}
