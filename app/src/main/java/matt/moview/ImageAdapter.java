package matt.moview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by MattsDesktop on 09/09/2016.
 */
public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds;
        private int mImageWidth=1; //initialized to one for no real reason, just in case for some reason PicAdapter isn't initialized properly
        private int mImageHeight=1;

    public ImageAdapter(Context c, Integer[] passedImageIds,int passedViewWidth,int passedNumberOfColumns) {
            mContext = c;
            mThumbIds=passedImageIds;
            mImageWidth=passedViewWidth/passedNumberOfColumns;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                mImageHeight=(int)Math.round(mImageWidth*1.5);
                imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth,mImageHeight));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView = (ImageView) convertView;
            }
            Picasso.with(mContext)
                    .load(mThumbIds[position])
                    .resize(mImageWidth,mImageHeight)
                    .centerCrop()
                    .into(imageView);
            return imageView;
        };
    }
