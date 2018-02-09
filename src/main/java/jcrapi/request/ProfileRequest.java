package jcrapi.request;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * @author Michael Lieshoff
 */
public class ProfileRequest extends Request {

    private final String tag;

    private ProfileRequest(String tag, int limit, List<String> excludes, List<String> includes) {
        super(limit, excludes, includes);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public static ProfileRequestBuilder builder() {
        return new ProfileRequestBuilder();
    }

    public static class ProfileRequestBuilder extends RequestBuilder<ProfileRequest, ProfileRequestBuilder> {

        private String tag;

        public ProfileRequestBuilder tag(String tag) {
            Preconditions.checkNotNull(tag, "tag");
            Preconditions.checkArgument(tag.length() > 0, "tag");
            this.tag = tag;
            return getThis();
        }

        @Override
        public ProfileRequest build() {
            return new ProfileRequest(tag, limit, excludes, includes);
        }

        @Override
        public ProfileRequestBuilder getThis() {
            return this;
        }

    }

}
