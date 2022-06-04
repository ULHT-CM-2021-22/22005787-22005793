package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0016\u0010#\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FiltersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireAdapter;", "binding", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/databinding/FragmentFiltersBinding;", "districts", "", "", "[Ljava/lang/String;", "estado", "filtroD", "", "filtroE", "filtroM", "filtroR", "meios", "radius", "viewModel", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOperationClick", "", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "onOperationLongClick", "onStart", "updateHistory", "", "app_debug"})
public final class FiltersFragment extends androidx.fragment.app.Fragment {
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireViewModel viewModel;
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.FireAdapter adapter;
    private boolean filtroR = false;
    private boolean filtroD = false;
    private boolean filtroM = false;
    private boolean filtroE = false;
    private java.lang.String[] districts = {"Aveiro", "Beja", "Braga", "Bragan\u00e7a", "Castelo Branco", "Coimbra", "\u00c9vora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre", "Porto", "Santar\u00e9m", "Set\u00fabal", "Viana do Castelo", "Vila Real", "Viseu"};
    private java.lang.String[] radius = {"50km", "150km", "300km"};
    private java.lang.String[] meios = {"Operacionais", "Meios Terrestres", "Meios Aereos"};
    private java.lang.String[] estado = {"A decorrer", "Conclu\u00eddo"};
    private pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.FragmentFiltersBinding binding;
    
    public FiltersFragment() {
        super();
    }
    
    private final boolean onOperationLongClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
        return false;
    }
    
    private final void onOperationClick(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
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
    
    private final void updateHistory(java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> fireData) {
    }
}