package android.example.miwok;

//contains the Miwok and Default translation

public class Word {
    //default translation for the word
    private String mDefaultTranslation;

    //miwok translation for the word
    private String mMiwokTranslation;

    //image resource ID for including images
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //to or not to add image
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    //constructor for including 4 object instances- 2-strings 2-int
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //constructor for including 3 object instances 2-strings 1-int
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    //get the default translation for the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //get the miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //get the image resource using the ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //to check whether it has image provision or not
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

//    @Override
//    public String toString() {
//        return "Word{" +
//                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
//                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
//                ", mImageResourceId=" + mImageResourceId +
//                ", mAudioResourceId=" + mAudioResourceId +
//                '}';
//    }
}
