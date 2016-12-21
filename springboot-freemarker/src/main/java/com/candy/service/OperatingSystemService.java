package com.candy.service;

/**
 * Created by Administrator on 2016/12/21.
 */

import com.candy.model.Performance;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatingSystemService {

    @Autowired
    private OperatingSystemMXBean operatingSystemMXBean;

    public Performance getPerformance() {
        Performance performance = new Performance();

        performance.setCommittedVirtualMemorySize(operatingSystemMXBean.getCommittedVirtualMemorySize());

        performance.setTotalSwapSpaceSize(operatingSystemMXBean.getTotalSwapSpaceSize());
        performance.setFreeSwapSpaceSize(operatingSystemMXBean.getFreeSwapSpaceSize());

        performance.setTotalPhysicalMemorySize(operatingSystemMXBean.getTotalPhysicalMemorySize());
        performance.setFreePhysicalMemorySize(operatingSystemMXBean.getFreePhysicalMemorySize());

        performance.setSystemCpuLoad(operatingSystemMXBean.getSystemCpuLoad());
        performance.setProcessCpuLoad(operatingSystemMXBean.getProcessCpuLoad());

        return performance;
    }
}

