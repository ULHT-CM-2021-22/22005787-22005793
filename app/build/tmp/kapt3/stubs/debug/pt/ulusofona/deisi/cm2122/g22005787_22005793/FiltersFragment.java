package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0016\u0010&\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FiltersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireAdapter;", "binding", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/databinding/FragmentFiltersBinding;", "districts", "", "", "[Ljava/lang/String;", "radius", "repository", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRepository;", "getRepository", "()Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRepository;", "viewModel", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "onCheckboxClicked", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOperationClick", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "onOperationLongClick", "", "onPause", "onResume", "onStart", "updateHistory", "", "app_debug"})
public final class FiltersFragment extends androidx.fragment.app.Fragment {
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireViewModel viewModel;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRepository repository = null;
    private java.lang.String[] districts = {"Aveiro", "Beja", "Braga", "Bragan\u00e7a", "Castelo Branco", "Coimbra", "\u00c9vora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre", "Porto", "Santar\u00e9m", "Set\u00fabal", "Viana do Castelo", "Vila Real", "Viseu"};
    private java.lang.String[] radius = {"50km", "150km", "300km"};
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFiltersBinding binding;
    
    public FiltersFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
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
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    public final void onCheckboxClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onOperationClick(@org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
    }
    
    private final boolean onOperationLongClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
        return false;
    }
    
    private final void updateHistory(java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> fireData) {
    }
}