
// ...........................................................................................................
//
// Copyright (c) 1993, 2014, Oracle and/or its affiliates. All rights reserved.
// THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Oracle Corp.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
// ...........................................................................................................

package presentation.utils.old;


import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Utility class that can be used to measure the time elapsed between two points.
 */
public class Chronometer
{
    //~ Instance fields ......................................................................................

    private final int    deep;
    private final String id;
    private final long   startTime = System.nanoTime();
    private final Logger logger;

    //~ Constructors .........................................................................................

    private Chronometer(@NotNull String startId, int deep, @NotNull Logger logger)
    {
        this.id = startId;
        this.deep = deep;
        this.logger = logger;
    }

    //~ Methods ..............................................................................................

    public static Chronometer start(@NotNull String startId, @NotNull Logger logger)
    {
        final List<Chronometer> logs = getEntries();
        final Chronometer       instance = new Chronometer(startId, logs.size() + 1, logger);
        logs.add(instance);
        return instance;
    }

    /**
     * Returns last started Chronometer
     *
     * @return last started Chronometer
     */
    private static Chronometer last()
    {
        final List<Chronometer> logs = getEntries();

        final int idx = logs.size() - 1;

        try {
            return logs.get(idx);
        }
        catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("start() must be invoked first", e);
        }
    }

    public static void stop()
    {
        last().end();
    }

    private boolean end()
    {
        final long enlapsed = System.nanoTime() - startTime;

        final List<Chronometer> logs = getEntries();

        final int last = logs.lastIndexOf(this);

        if (last != -1) {
            logs.subList(last, logs.size()).clear();
        }

        long scale = 100000000000L;
        int  unitIdx = -1;

        while (enlapsed < scale - 1 && scale > 100) {
            scale /= 1000;
            unitIdx++;
        }

        scale /= 100;

        final int    value = (int) ((enlapsed + scale / 2) / scale);
        final String prefix = unitIdx == -1 ? "" : "mµn".substring(unitIdx, unitIdx + 1);
        logger.log(Level.FINE, "({}) {}->{}{}s", new Object[] {
                     Integer.toString(deep), id, Integer.toString(value), prefix });
        return true;
    }

    private static List<Chronometer> getEntries()
    {
        final ThreadLocal<List<Chronometer>> tl = THREAD_LOCAL;

        List<Chronometer> result = tl.get();

        if (result == null) {
            result = new ArrayList<Chronometer>();
            tl.set(result);
        }

        return result;
    }

    //~ Static fields/initializers ...........................................................................

    private static final ThreadLocal<List<Chronometer>> THREAD_LOCAL = new ThreadLocal<List<Chronometer>>();
}
