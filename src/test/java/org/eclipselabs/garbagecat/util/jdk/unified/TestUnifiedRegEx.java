/**********************************************************************************************************************
 * garbagecat                                                                                                         *
 *                                                                                                                    *
 * Copyright (c) 2008-2023 Mike Millson                                                                               *
 *                                                                                                                    * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse *
 * Public License v1.0 which accompanies this distribution, and is available at                                       *
 * http://www.eclipse.org/legal/epl-v10.html.                                                                         *
 *                                                                                                                    *
 * Contributors:                                                                                                      *
 *    Mike Millson - initial API and implementation                                                                   *
 *********************************************************************************************************************/
package org.eclipselabs.garbagecat.util.jdk.unified;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipselabs.garbagecat.util.jdk.JdkRegEx;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:mmillson@redhat.com">Mike Millson</a>
 * 
 */
class TestUnifiedRegEx {

    @Test
    void testDecoratorGcAge() {
        String decorator = "[2022-08-03T06:58:41.313+0000][gc,age      ] GC(0)";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorGcCds() {
        String decorator = "[0.004s][info][gc,cds       ]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorGcRef() {
        String decorator = "[0.212s][info][gc,ref      ]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorGcStringdedup() {
        String decorator = "[2021-10-13T13:31:38.618+0400][info][gc,stringdedup]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorNoInfo() {
        String decorator = "[2022-08-03T06:58:38.019+0000][safepoint   ]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorSafepoint() {
        String decorator = "[0.031s][info][safepoint    ]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorTime() {
        String decorator = "[2020-02-14T15:21:55.207-0500]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorTimePidTags() {
        String decorator = "[2022-08-03T06:58:37.646+0000][1863][gc,init]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorTimeUptime() {
        String decorator = "[2020-02-14T15:21:55.207-0500][25.016s]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorTimeUptimemillis() {
        String decorator = "[2020-02-14T15:21:55.207-0500][25016ms]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorUptime() {
        String decorator = "[25.016s]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorUptimeMillis() {
        String decorator = "[25016ms]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorUptimeMillis15Digits() {
        String decorator = "[115443156312345ms]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDecoratorWithSpaces() {
        String decorator = "[932126.909s][info   ][safepoint     ]";
        assertTrue(decorator.matches(UnifiedRegEx.DECORATOR), "Decorator " + decorator + " not recognized.");
    }

    @Test
    void testDurationJdk9() {
        String duration = "2.969ms";
        assertTrue(duration.matches(JdkRegEx.DURATION_MS), "'" + duration + "' is a valid duration.");
    }

    @Test
    void testDurationJdk9WithSpace() {
        String duration = "15.91 ms";
        assertTrue(duration.matches(JdkRegEx.DURATION_MS), "'" + duration + "' is a valid duration.");
    }

    @Test
    void testGcEventId() {
        String id = "GC(1326)";
        assertTrue(id.matches(UnifiedRegEx.GC_EVENT_NUMBER), "'" + id + "' is a valid GC event id.");
    }

    @Test
    void testGcEventId7Digits() {
        String id = "GC(1234567)";
        assertTrue(id.matches(UnifiedRegEx.GC_EVENT_NUMBER), "'" + id + "' is a valid GC event id.");
    }

    @Test
    void testReleaseStringJdk11() {
        String release = "11.0.9+11-LTS";
        assertTrue(release.matches(UnifiedRegEx.RELEASE_STRING), "Release string " + release + " not recognized.");
    }

    @Test
    void testReleaseStringJdk12() {
        String release = "12.0.1+12";
        assertTrue(release.matches(UnifiedRegEx.RELEASE_STRING), "Release string " + release + " not recognized.");
    }

    @Test
    void testReleaseStringJdk17() {
        String release = "17.0.1+12-LTS";
        assertTrue(release.matches(UnifiedRegEx.RELEASE_STRING), "Release string " + release + " not recognized.");
    }

    @Test
    void testTimestampUnifiedLogging() {
        String timestamp = "0.002s";
        assertTrue(timestamp.matches(UnifiedRegEx.UPTIME), "'" + timestamp + "' is a valid timestamp.");
    }
}
