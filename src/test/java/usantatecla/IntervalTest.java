package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }


  @Test void givenIntervalWhenSameIntervalThenInterseccionIsSameIntervalThenTrue(){

    Interval interval1 = new Interval(new Min(this.left.getEquals()), new Max(this.right.getEquals()));
    Interval interval2 = new Interval(new Min(this.left.getEquals()), new Max(this.right.getEquals()));

    assertTrue(interval1.intersection(interval2).equals(interval1));
    assertTrue(interval1.intersection(interval2).equals(interval2));

  }

  @Test void givenIntervalWhenIntervalWith1ElementThenInterseccionIsElementIntervalThenTrue(){

    Interval interval1 = new Interval(new Min(this.left.getEquals()), new Max(this.right.getEquals()));
    Interval interval2 = new Interval(new Min(this.right.getLess()), new Max(this.right.getEquals()));

    assertTrue(interval1.intersection(interval2).equals(new Interval (new Min(this.right.getLess()),new Max(this.right.getEquals()))));

  }


 /* @Test void givenIntervalWhenDisjointedIntervalThenInterseccionIsSameIntervalThenFalse(){

    Interval interval1 = new Interval(new Min(this.left.getEquals()), new Max(this.right.getEquals()));
    Interval interval2 = new Interval(new Min(this.right.getGreater()), new Max(this.left.getEquals() + this.right.getEquals()));

    assertFalse(interval1.intersection(interval2).equals(interval1));
    //assertFalse(interval1.intersection(interval2).equals(interval2));

  }*/




}