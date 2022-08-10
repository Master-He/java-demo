package com.github.base.system;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * @author hewenji
 * @Date 2022/8/10 20:20
 */
public class SystemInfo {

    public static void main1() {
        // 虚拟机级内存情况查询
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory() / byteToMb;
        vmFree = rt.freeMemory() / byteToMb;
        vmMax = rt.maxMemory() / byteToMb;
        vmUse = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
        System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
        System.out.println("JVM总内存空间为：" + vmTotal + " MB");
        System.out.println("JVM总内存空间为：" + vmMax + " MB");

        System.out.println("======================================");
        // 操作系统级内存情况查询
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String os = System.getProperty("os.name");
        long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
        long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
        long physicalUse = physicalTotal - physicalFree;
        System.out.println("操作系统的版本：" + os);
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("操作系统物理内存的空闲空间为：" + physicalUse + " MB");
        System.out.println("操作系统总物理内存：" + physicalTotal + " MB");

        // 获得线程总数
        ThreadGroup parentThread;
        int totalThread = 0;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
            .getParent() != null; parentThread = parentThread.getParent()) {
            totalThread = parentThread.activeCount();
        }
        System.out.println("获得线程总数:" + totalThread);
    }

    public static void main(String[] args) {
        //获取内存
        getMemInfo();
        //获取cpu
        getCpuInfo();
        //获取磁盘
        getDiskInfo();

        // main1
        main1();
    }

    public static void getDiskInfo() {
        File[] disks = File.listRoots();
        for (File file : disks) {
            System.out.print(file.getPath() + "    ");
            System.out.print("空闲未使用 = " + file.getFreeSpace() / 1024 / 1024 / 1024 + "G" + "    ");// 空闲空间
            System.out.print("可使用 = " + file.getUsableSpace() / 1024 / 1024 / 1024 + "G" + "    ");// 可用空间
            System.out.print("总容量 = " + file.getTotalSpace() / 1024 / 1024 / 1024 + "G" + "    ");// 总空间
            System.out.println();
        }
    }

    public static void getMemInfo() {
        OperatingSystemMXBean mxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Total RAM：" + mxBean.getTotalPhysicalMemorySize() / 1024 / 1024 / 1024 + "GB");
        System.out.println("Available　RAM：" + mxBean.getFreePhysicalMemorySize() / 1024 / 1024 / 1024 + "GB");
    }

    public static void getCpuInfo() {
        OperatingSystemMXBean mxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double processCpuLoad = mxBean.getProcessCpuLoad();
        double systemCpuLoad = mxBean.getSystemCpuLoad();
        long processCpuTime = mxBean.getProcessCpuTime();
        System.out.println("cpu1:" + processCpuLoad);
        System.out.println("cpu2:" + systemCpuLoad);
        System.out.println("cpu3:" + processCpuTime);
    }
}
