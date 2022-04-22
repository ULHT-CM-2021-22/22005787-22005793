// Generated by view binder compiler. Do not edit!
package pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pt.ulusofona.deisi.cm2122.g22005787_22005793.R;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button buttonRegion;

  @NonNull
  public final ImageView imageview1;

  @NonNull
  public final ImageView imageview2;

  @NonNull
  public final ImageView imageview3;

  @NonNull
  public final ImageView imageview4;

  @NonNull
  public final ImageView imageview5;

  @NonNull
  public final TextView textRegion;

  private FragmentDashboardBinding(@NonNull FrameLayout rootView, @NonNull Button buttonRegion,
      @NonNull ImageView imageview1, @NonNull ImageView imageview2, @NonNull ImageView imageview3,
      @NonNull ImageView imageview4, @NonNull ImageView imageview5, @NonNull TextView textRegion) {
    this.rootView = rootView;
    this.buttonRegion = buttonRegion;
    this.imageview1 = imageview1;
    this.imageview2 = imageview2;
    this.imageview3 = imageview3;
    this.imageview4 = imageview4;
    this.imageview5 = imageview5;
    this.textRegion = textRegion;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_region;
      Button buttonRegion = ViewBindings.findChildViewById(rootView, id);
      if (buttonRegion == null) {
        break missingId;
      }

      id = R.id.imageview1;
      ImageView imageview1 = ViewBindings.findChildViewById(rootView, id);
      if (imageview1 == null) {
        break missingId;
      }

      id = R.id.imageview2;
      ImageView imageview2 = ViewBindings.findChildViewById(rootView, id);
      if (imageview2 == null) {
        break missingId;
      }

      id = R.id.imageview3;
      ImageView imageview3 = ViewBindings.findChildViewById(rootView, id);
      if (imageview3 == null) {
        break missingId;
      }

      id = R.id.imageview4;
      ImageView imageview4 = ViewBindings.findChildViewById(rootView, id);
      if (imageview4 == null) {
        break missingId;
      }

      id = R.id.imageview5;
      ImageView imageview5 = ViewBindings.findChildViewById(rootView, id);
      if (imageview5 == null) {
        break missingId;
      }

      id = R.id.text_region;
      TextView textRegion = ViewBindings.findChildViewById(rootView, id);
      if (textRegion == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((FrameLayout) rootView, buttonRegion, imageview1,
          imageview2, imageview3, imageview4, imageview5, textRegion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}