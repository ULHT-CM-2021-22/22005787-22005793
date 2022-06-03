package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FusedLocation;", "Lcom/google/android/gms/location/LocationCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "kotlin.jvm.PlatformType", "TIME_BETWEEN_UPDATES", "", "client", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "onLocationResult", "", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "Companion", "app_debug"})
public final class FusedLocation extends com.google.android.gms.location.LocationCallback {
    private final java.lang.String TAG = null;
    private final long TIME_BETWEEN_UPDATES = 5000L;
    private com.google.android.gms.location.LocationRequest locationRequest;
    private com.google.android.gms.location.FusedLocationProviderClient client;
    @org.jetbrains.annotations.NotNull()
    public static final pt.ulusofona.deisi.cm2122.g22005787_22005793.FusedLocation.Companion Companion = null;
    private static final java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.OnLocationChangedListener> listeners = null;
    private static pt.ulusofona.deisi.cm2122.g22005787_22005793.FusedLocation instance;
    
    private FusedLocation(android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public void onLocationResult(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationResult locationResult) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FusedLocation$Companion;", "", "()V", "instance", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FusedLocation;", "listeners", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/OnLocationChangedListener;", "notifyListener", "", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "registerListener", "listener", "start", "context", "Landroid/content/Context;", "unregisterListener", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void registerListener(@org.jetbrains.annotations.NotNull()
        pt.ulusofona.deisi.cm2122.g22005787_22005793.OnLocationChangedListener listener) {
        }
        
        public final void unregisterListener(@org.jetbrains.annotations.NotNull()
        pt.ulusofona.deisi.cm2122.g22005787_22005793.OnLocationChangedListener listener) {
        }
        
        public final void notifyListener(@org.jetbrains.annotations.NotNull()
        com.google.android.gms.location.LocationResult locationResult) {
        }
        
        public final void start(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}