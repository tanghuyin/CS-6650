package benchmark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@BenchmarkMode(Mode.AverageTime)  //统计平均时间
@OutputTimeUnit(TimeUnit.MICROSECONDS) //单位微秒
@Warmup(iterations = 10) //预热10次
@Measurement(iterations = 10)  //度量10次
public class IntegerSpeedTest {

  @State(Scope.Group)
  public static class SingleMonitor{
    private int i = 0;
    public void singleInc() {
      for (int i = 0; i < 10; i++) {

      }
    }
  }

  @State(Scope.Group)
  public static class SynMonitor {
    private int i = 0;

    public void synInc() {
      synchronized (this) {
        i++;
      }
    }
  }

  @State(Scope.Group)
  public static class LockMonitor {
    private final Lock lock = new ReentrantLock();
    private int i = 0;

    public void lockInc() {
      lock.lock();
      try {
        i++;
      } finally {
        lock.unlock();
      }
    }
  }

  @State(Scope.Group)
  public static class AtomicIntegerMonitor {
    private AtomicInteger i = new AtomicInteger(0);

    public void inc() {
      i.incrementAndGet();
    }
  }

  //定义基准方法，测试synchronized修饰的性能
  @GroupThreads(1) //线程数量
  @Group("single") //线程组名称
  @Benchmark
  public void singleInc(SingleMonitor singleMonitor) {
    singleMonitor.singleInc();
  }

  //定义基准方法，测试synchronized修饰的性能
  @GroupThreads(10) //线程数量
  @Group("sync") //线程组名称
  @Benchmark
  public void synInc(SynMonitor synMonitor) {
    synMonitor.synInc();
  }

  //定义基准方法，测试显示锁Lock性能
  @GroupThreads(10)
  @Group("lock")
  @Benchmark
  public void lockInc(LockMonitor lockMonitor) {
    lockMonitor.lockInc();
  }

  //定义基准方法，测试AtomicInteger性能
  @GroupThreads(10)
  @Group("atomic")
  @Benchmark
  public void atomicInc(AtomicIntegerMonitor atomicIntegerMonitor) {
    atomicIntegerMonitor.inc();
  }

  public static void main(String[] args) throws Exception {
    Options options = new OptionsBuilder().include(IntegerSpeedTest.class.getSimpleName())
        .addProfiler(StackProfiler.class)
        .forks(1)
        .timeout(TimeValue.seconds(10))
        .build();
    new Runner(options).run();
  }
}