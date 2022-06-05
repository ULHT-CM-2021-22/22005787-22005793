package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\tH\u0002J\u0016\u0010(\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireListFragment;", "Landroidx/fragment/app/Fragment;", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/OnLocationChangedListener;", "()V", "adapter", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireAdapter;", "binding", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/databinding/FragmentFireListBinding;", "filter", "", "geocoder", "Landroid/location/Geocoder;", "viewModel", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "backgroundColor", "", "risk", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLocationChanged", "latitude", "", "longitude", "onOperationClick", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "onOperationLongClick", "onResume", "onStart", "placeCityName", "showHistory", "show", "updateHistory", "", "app_debug"})
public final class FireListFragment extends androidx.fragment.app.Fragment implements pt.ulusofona.deisi.cm2122.g22005787_22005793.OnLocationChangedListener {
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireViewModel viewModel;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireAdapter adapter;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFireListBinding binding;
    private android.location.Geocoder geocoder;
    private boolean filter = false;
    
    public FireListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
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
    
    private final void onOperationClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
    }
    
    private final boolean onOperationLongClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
        return false;
    }
    
    private final void updateHistory(java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> fireData) {
    }
    
    private final void showHistory(boolean show) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void backgroundColor(java.lang.String risk) {
    }
    
    private final void placeCityName(double latitude, double longitude) {
    }
    
    @java.lang.Override()
    public void onLocationChanged(double latitude, double longitude) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}