package com.ryan.geode.resolver;

import org.apache.geode.cache.EntryOperation;
import org.apache.geode.cache.PartitionResolver;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/20 10:54.
 */
public class CustomerOrderResolver implements PartitionResolver<String, String> {
    /**
     * @param opDetails the detail of the entry operation e.g.
     *                  {@link Region#get(Object)}
     * @return object associated with entry operation which allows the Partitioned
     * Region to store associated data together
     * @throws RuntimeException any exception thrown will terminate the operation and the
     *                          exception will be passed to the calling thread.
     */
    @Override
    public Object getRoutingObject(EntryOperation<String, String> opDetails) {


        return null;
    }

    /**
     * Returns the name of the PartitionResolver
     *
     * @return String name
     */
    @Override
    public String getName() {
        return "CustomerOrderResolver";
    }

    /**
     * Called when the region containing this callback is closed or destroyed, when
     * the cache is closed, or when a callback is removed from a region
     * using an <code>AttributesMutator</code>.
     * <p>
     * <p>Implementations should cleanup any external
     * resources such as database connections. Any runtime exceptions this method
     * throws will be logged.
     * <p>
     * <p>It is possible for this method to be called multiple times on a single
     * callback instance, so implementations must be tolerant of this.
     *
     * @see Cache#close()
     * @see Region#close
     * @see Region#localDestroyRegion()
     * @see Region#destroyRegion()
     * @see AttributesMutator
     */
    @Override
    public void close() {

    }
}
