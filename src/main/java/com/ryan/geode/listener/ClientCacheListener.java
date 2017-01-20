package com.ryan.geode.listener;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/20 10:51.
 */
public class ClientCacheListener implements CacheListener<String, String> {

    private static final Logger LOG = LoggerFactory.getLogger(ClientCacheListener.class);




    /**
     * Handles the event of new key being added to a region. The entry did not
     * previously exist in this region in the local cache (even with a null
     * value).
     *
     * @param event the EntryEvent
     * @see Region#create(Object, Object)
     * @see Region#put(Object, Object)
     * @see Region#get(Object)
     */
    @Override
    public void afterCreate(EntryEvent<String, String> event) {

        LOG.info("afterCreate : {} --- {}", event.getKey(), event.getNewValue());
    }

    /**
     * Handles the event of an entry's value being modified in a region. This
     * entry previously existed in this region in the local cache, but its
     * previous value may have been null.
     *
     * @param event the EntryEvent
     * @see Region#put(Object, Object)
     */
    @Override
    public void afterUpdate(EntryEvent<String, String> event) {
        LOG.info("afterUpdate : {} --- {}", event.getKey(), event.getNewValue());
    }

    /**
     * Handles the event of an entry's value being invalidated.
     *
     * @param event the EntryEvent
     * @see Region#invalidate(Object)
     */
    @Override
    public void afterInvalidate(EntryEvent<String, String> event) {
        LOG.info("afterInvalidate : {} --- {}", event.getKey(), event.getNewValue());
    }

    /**
     * Handles the event of an entry being destroyed.
     *
     * @param event the EntryEvent
     * @see Region#destroy(Object)
     */
    @Override
    public void afterDestroy(EntryEvent<String, String> event) {


        LOG.info("afterDestroy : {} --- {}", event.getKey(), event.getNewValue());

    }

    /**
     * Handles the event of a region being invalidated. Events are not invoked for
     * each individual value that is invalidated as a result of the region being
     * invalidated. Each subregion, however, gets its own
     * <code>regionInvalidated</code> event invoked on its listener.
     *
     * @param event the RegionEvent
     * @see Region#invalidateRegion()
     * @see Region#localInvalidateRegion()
     */
    @Override
    public void afterRegionInvalidate(RegionEvent<String, String> event) {


        LOG.info("afterRegionInvalidate : {} --- {}", event.getCallbackArgument(), event.getOperation().isCreate());
    }

    /**
     * Handles the event of a region being destroyed. Events are not invoked for
     * each individual entry that is destroyed as a result of the region being
     * destroyed. Each subregion, however, gets its own
     * <code>afterRegionDestroyed</code> event invoked on its listener.
     *
     * @param event the RegionEvent
     * @see Region#destroyRegion()
     * @see Region#localDestroyRegion()
     * @see Region#close
     * @see Cache#close()
     */
    @Override
    public void afterRegionDestroy(RegionEvent<String, String> event) {


        LOG.info("afterRegionDestroy : {} --- {}", event.getCallbackArgument(), event.getOperation().isCreate());
    }

    /**
     * Handles the event of a region being cleared. Events are not invoked for
     * each individual entry that is removed as a result of the region being
     * cleared.
     *
     * @param event the RegionEvent
     * @see Region#clear
     * @since GemFire 5.0
     */
    @Override
    public void afterRegionClear(RegionEvent<String, String> event) {

        LOG.info("afterRegionClear : {} --- {}", event.getCallbackArgument(), event.getOperation().isCreate());


    }

    /**
     * Handles the event of a region being created. Events are invoked for
     * each individual region that is created.
     * <p>Note that this method is only called
     * for creates done in the local vm. To be notified of creates done in remote
     * vms use {@link RegionMembershipListener#afterRemoteRegionCreate}.
     *
     * @param event the RegionEvent
     * @see Cache#createRegion
     * @see Region#createSubregion
     * @since GemFire 5.0
     */
    @Override
    public void afterRegionCreate(RegionEvent<String, String> event) {


        LOG.info("afterRegionCreate : {} --- {}", event.getCallbackArgument(), event.getOperation().isCreate());


    }

    /**
     * Handles the event of a region being live after receiving the marker from the server.
     *
     * @param event the RegionEvent
     * @see Cache#readyForEvents
     * @since GemFire 5.5
     */
    @Override
    public void afterRegionLive(RegionEvent<String, String> event) {

        LOG.info("afterRegionLive : {} --- {}", event.getCallbackArgument(), event.getOperation().isCreate());
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

        LOG.info("close ");

    }
}
