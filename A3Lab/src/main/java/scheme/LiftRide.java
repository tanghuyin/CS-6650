package scheme;

public class LiftRide {
  private short time;
  private short liftID;
  private short waitTime;

  public LiftRide(short time, short liftID, short waitTime) {
    this.time = time;
    this.liftID = liftID;
    this.waitTime = waitTime;
  }

  /**
   * Gets time.
   *
   * @return value of time
   */
  public short getTime() {
    return time;
  }

  /**
   * Sets time.
   *
   * @param time value of time
   */
  public void setTime(short time) {
    this.time = time;
  }

  /**
   * Gets liftID.
   *
   * @return value of liftID
   */
  public short getLiftID() {
    return liftID;
  }

  /**
   * Sets liftID.
   *
   * @param liftID value of liftID
   */
  public void setLiftID(short liftID) {
    this.liftID = liftID;
  }

  /**
   * Gets waitTime.
   *
   * @return value of waitTime
   */
  public short getWaitTime() {
    return waitTime;
  }

  /**
   * Sets waitTime.
   *
   * @param waitTime value of waitTime
   */
  public void setWaitTime(short waitTime) {
    this.waitTime = waitTime;
  }

  @Override
  public String toString() {
    return "LiftRide{" +
        "time=" + time +
        ", liftID=" + liftID +
        ", waitTime=" + waitTime +
        '}';
  }
}
