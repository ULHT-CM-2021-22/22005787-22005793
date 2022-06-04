package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\'H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010)\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u0018\u0010.\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u0016\u0010/\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireMapFragment;", "Landroidx/fragment/app/Fragment;", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/OnLocationChangedListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "adapter", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireAdapter;", "binding", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/databinding/FragmentFireMapBinding;", "geocoder", "Landroid/location/Geocoder;", "listFires", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "viewModel", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "backgroundColor", "", "risk", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLocationChanged", "latitude", "", "longitude", "onMapReady", "p0", "onMarkerClick", "", "Lcom/google/android/gms/maps/model/Marker;", "onOperationClick", "fireData", "onOperationLongClick", "onPause", "onResume", "onStart", "placeCamera", "updateHistory", "app_debug"})
public final class FireMapFragment extends androidx.fragment.app.Fragment implements pt.ulusofona.deisi.cm2122.g22005787_22005793.OnLocationChangedListener, com.google.android.gms.maps.OnMapReadyCallback {
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireMapBinding binding;
    private android.location.Geocoder geocoder;
    private com.google.android.gms.maps.GoogleMap map;
    private java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> listFires;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireAdapter adapter;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireViewModel viewModel;
    
    public FireMapFragment() {
        super();
    }
    
    private final boolean onOperationLongClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
        return false;
    }
    
    private final void onOperationClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onLocationChanged(double latitude, double longitude) {
    }
    
    private final void placeCamera(double latitude, double longitude) {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void updateHistory(java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> fireData) {
    }
    
    private final void backgroundColor(java.lang.String risk) {
    }
    
    private final boolean onMarkerClick(com.google.android.gms.maps.model.Marker p0) {
        return false;
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap p0) {
    }
}