package play.utils.old;

import com.sun.istack.internal.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ChronometeredOperation<T, E extends Exception>
{

    public T invoke(@NotNull final Logger logger, @NotNull final String methodName)
        throws E
    {
        try {

            if (logger.isLoggable(Level.FINEST)) {
                final String id = "Execution time for " + methodName;
                Chronometer.start(id, logger);
            }

            return doInvoke();
        }
        finally {
            if (logger.isLoggable(Level.FINEST)) {
                Chronometer.stop();
            }
        }
    }

    protected abstract T doInvoke()
        throws E;
}
