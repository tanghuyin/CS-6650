package scheme;

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SkiDayVertical.proto

public final class SkiDayVerticalOuterClass {
  private SkiDayVerticalOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SkiDayVerticalOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SkiDayVertical)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string resortID = 1;</code>
     * @return The resortID.
     */
    java.lang.String getResortID();
    /**
     * <code>string resortID = 1;</code>
     * @return The bytes for resortID.
     */
    com.google.protobuf.ByteString
    getResortIDBytes();

    /**
     * <code>string seasonID = 2;</code>
     * @return The seasonID.
     */
    java.lang.String getSeasonID();
    /**
     * <code>string seasonID = 2;</code>
     * @return The bytes for seasonID.
     */
    com.google.protobuf.ByteString
    getSeasonIDBytes();

    /**
     * <code>string dayID = 3;</code>
     * @return The dayID.
     */
    java.lang.String getDayID();
    /**
     * <code>string dayID = 3;</code>
     * @return The bytes for dayID.
     */
    com.google.protobuf.ByteString
    getDayIDBytes();

    /**
     * <code>string skierID = 4;</code>
     * @return The skierID.
     */
    java.lang.String getSkierID();
    /**
     * <code>string skierID = 4;</code>
     * @return The bytes for skierID.
     */
    com.google.protobuf.ByteString
    getSkierIDBytes();

    /**
     * <code>int32 time = 5;</code>
     * @return The time.
     */
    int getTime();

    /**
     * <code>int32 liftID = 6;</code>
     * @return The liftID.
     */
    int getLiftID();

    /**
     * <code>int32 waitTime = 7;</code>
     * @return The waitTime.
     */
    int getWaitTime();
  }
  /**
   * Protobuf type {@code SkiDayVertical}
   */
  public static final class SkiDayVertical extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SkiDayVertical)
      SkiDayVerticalOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use SkiDayVertical.newBuilder() to construct.
    private SkiDayVertical(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SkiDayVertical() {
      resortID_ = "";
      seasonID_ = "";
      dayID_ = "";
      skierID_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new SkiDayVertical();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SkiDayVertical(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              resortID_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              seasonID_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              dayID_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              skierID_ = s;
              break;
            }
            case 40: {

              time_ = input.readInt32();
              break;
            }
            case 48: {

              liftID_ = input.readInt32();
              break;
            }
            case 56: {

              waitTime_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return SkiDayVerticalOuterClass.internal_static_SkiDayVertical_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return SkiDayVerticalOuterClass.internal_static_SkiDayVertical_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SkiDayVerticalOuterClass.SkiDayVertical.class, SkiDayVerticalOuterClass.SkiDayVertical.Builder.class);
    }

    public static final int RESORTID_FIELD_NUMBER = 1;
    private volatile java.lang.Object resortID_;
    /**
     * <code>string resortID = 1;</code>
     * @return The resortID.
     */
    @java.lang.Override
    public java.lang.String getResortID() {
      java.lang.Object ref = resortID_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        resortID_ = s;
        return s;
      }
    }
    /**
     * <code>string resortID = 1;</code>
     * @return The bytes for resortID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getResortIDBytes() {
      java.lang.Object ref = resortID_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        resortID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SEASONID_FIELD_NUMBER = 2;
    private volatile java.lang.Object seasonID_;
    /**
     * <code>string seasonID = 2;</code>
     * @return The seasonID.
     */
    @java.lang.Override
    public java.lang.String getSeasonID() {
      java.lang.Object ref = seasonID_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        seasonID_ = s;
        return s;
      }
    }
    /**
     * <code>string seasonID = 2;</code>
     * @return The bytes for seasonID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getSeasonIDBytes() {
      java.lang.Object ref = seasonID_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        seasonID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DAYID_FIELD_NUMBER = 3;
    private volatile java.lang.Object dayID_;
    /**
     * <code>string dayID = 3;</code>
     * @return The dayID.
     */
    @java.lang.Override
    public java.lang.String getDayID() {
      java.lang.Object ref = dayID_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dayID_ = s;
        return s;
      }
    }
    /**
     * <code>string dayID = 3;</code>
     * @return The bytes for dayID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getDayIDBytes() {
      java.lang.Object ref = dayID_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dayID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SKIERID_FIELD_NUMBER = 4;
    private volatile java.lang.Object skierID_;
    /**
     * <code>string skierID = 4;</code>
     * @return The skierID.
     */
    @java.lang.Override
    public java.lang.String getSkierID() {
      java.lang.Object ref = skierID_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        skierID_ = s;
        return s;
      }
    }
    /**
     * <code>string skierID = 4;</code>
     * @return The bytes for skierID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getSkierIDBytes() {
      java.lang.Object ref = skierID_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        skierID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIME_FIELD_NUMBER = 5;
    private int time_;
    /**
     * <code>int32 time = 5;</code>
     * @return The time.
     */
    @java.lang.Override
    public int getTime() {
      return time_;
    }

    public static final int LIFTID_FIELD_NUMBER = 6;
    private int liftID_;
    /**
     * <code>int32 liftID = 6;</code>
     * @return The liftID.
     */
    @java.lang.Override
    public int getLiftID() {
      return liftID_;
    }

    public static final int WAITTIME_FIELD_NUMBER = 7;
    private int waitTime_;
    /**
     * <code>int32 waitTime = 7;</code>
     * @return The waitTime.
     */
    @java.lang.Override
    public int getWaitTime() {
      return waitTime_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(resortID_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, resortID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(seasonID_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, seasonID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(dayID_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dayID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(skierID_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, skierID_);
      }
      if (time_ != 0) {
        output.writeInt32(5, time_);
      }
      if (liftID_ != 0) {
        output.writeInt32(6, liftID_);
      }
      if (waitTime_ != 0) {
        output.writeInt32(7, waitTime_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(resortID_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, resortID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(seasonID_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, seasonID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(dayID_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dayID_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(skierID_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, skierID_);
      }
      if (time_ != 0) {
        size += com.google.protobuf.CodedOutputStream
            .computeInt32Size(5, time_);
      }
      if (liftID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
            .computeInt32Size(6, liftID_);
      }
      if (waitTime_ != 0) {
        size += com.google.protobuf.CodedOutputStream
            .computeInt32Size(7, waitTime_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof SkiDayVerticalOuterClass.SkiDayVertical)) {
        return super.equals(obj);
      }
      SkiDayVerticalOuterClass.SkiDayVertical other = (SkiDayVerticalOuterClass.SkiDayVertical) obj;

      if (!getResortID()
          .equals(other.getResortID())) return false;
      if (!getSeasonID()
          .equals(other.getSeasonID())) return false;
      if (!getDayID()
          .equals(other.getDayID())) return false;
      if (!getSkierID()
          .equals(other.getSkierID())) return false;
      if (getTime()
          != other.getTime()) return false;
      if (getLiftID()
          != other.getLiftID()) return false;
      if (getWaitTime()
          != other.getWaitTime()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + RESORTID_FIELD_NUMBER;
      hash = (53 * hash) + getResortID().hashCode();
      hash = (37 * hash) + SEASONID_FIELD_NUMBER;
      hash = (53 * hash) + getSeasonID().hashCode();
      hash = (37 * hash) + DAYID_FIELD_NUMBER;
      hash = (53 * hash) + getDayID().hashCode();
      hash = (37 * hash) + SKIERID_FIELD_NUMBER;
      hash = (53 * hash) + getSkierID().hashCode();
      hash = (37 * hash) + TIME_FIELD_NUMBER;
      hash = (53 * hash) + getTime();
      hash = (37 * hash) + LIFTID_FIELD_NUMBER;
      hash = (53 * hash) + getLiftID();
      hash = (37 * hash) + WAITTIME_FIELD_NUMBER;
      hash = (53 * hash) + getWaitTime();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SkiDayVerticalOuterClass.SkiDayVertical parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(SkiDayVerticalOuterClass.SkiDayVertical prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code SkiDayVertical}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SkiDayVertical)
        SkiDayVerticalOuterClass.SkiDayVerticalOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return SkiDayVerticalOuterClass.internal_static_SkiDayVertical_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return SkiDayVerticalOuterClass.internal_static_SkiDayVertical_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                SkiDayVerticalOuterClass.SkiDayVertical.class, SkiDayVerticalOuterClass.SkiDayVertical.Builder.class);
      }

      // Construct using SkiDayVerticalOuterClass.SkiDayVertical.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
            .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        resortID_ = "";

        seasonID_ = "";

        dayID_ = "";

        skierID_ = "";

        time_ = 0;

        liftID_ = 0;

        waitTime_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return SkiDayVerticalOuterClass.internal_static_SkiDayVertical_descriptor;
      }

      @java.lang.Override
      public SkiDayVerticalOuterClass.SkiDayVertical getDefaultInstanceForType() {
        return SkiDayVerticalOuterClass.SkiDayVertical.getDefaultInstance();
      }

      @java.lang.Override
      public SkiDayVerticalOuterClass.SkiDayVertical build() {
        SkiDayVerticalOuterClass.SkiDayVertical result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public SkiDayVerticalOuterClass.SkiDayVertical buildPartial() {
        SkiDayVerticalOuterClass.SkiDayVertical result = new SkiDayVerticalOuterClass.SkiDayVertical(this);
        result.resortID_ = resortID_;
        result.seasonID_ = seasonID_;
        result.dayID_ = dayID_;
        result.skierID_ = skierID_;
        result.time_ = time_;
        result.liftID_ = liftID_;
        result.waitTime_ = waitTime_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof SkiDayVerticalOuterClass.SkiDayVertical) {
          return mergeFrom((SkiDayVerticalOuterClass.SkiDayVertical)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(SkiDayVerticalOuterClass.SkiDayVertical other) {
        if (other == SkiDayVerticalOuterClass.SkiDayVertical.getDefaultInstance()) return this;
        if (!other.getResortID().isEmpty()) {
          resortID_ = other.resortID_;
          onChanged();
        }
        if (!other.getSeasonID().isEmpty()) {
          seasonID_ = other.seasonID_;
          onChanged();
        }
        if (!other.getDayID().isEmpty()) {
          dayID_ = other.dayID_;
          onChanged();
        }
        if (!other.getSkierID().isEmpty()) {
          skierID_ = other.skierID_;
          onChanged();
        }
        if (other.getTime() != 0) {
          setTime(other.getTime());
        }
        if (other.getLiftID() != 0) {
          setLiftID(other.getLiftID());
        }
        if (other.getWaitTime() != 0) {
          setWaitTime(other.getWaitTime());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        SkiDayVerticalOuterClass.SkiDayVertical parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (SkiDayVerticalOuterClass.SkiDayVertical) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object resortID_ = "";
      /**
       * <code>string resortID = 1;</code>
       * @return The resortID.
       */
      public java.lang.String getResortID() {
        java.lang.Object ref = resortID_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          resortID_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string resortID = 1;</code>
       * @return The bytes for resortID.
       */
      public com.google.protobuf.ByteString
      getResortIDBytes() {
        java.lang.Object ref = resortID_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          resortID_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string resortID = 1;</code>
       * @param value The resortID to set.
       * @return This builder for chaining.
       */
      public Builder setResortID(
          java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        resortID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string resortID = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearResortID() {

        resortID_ = getDefaultInstance().getResortID();
        onChanged();
        return this;
      }
      /**
       * <code>string resortID = 1;</code>
       * @param value The bytes for resortID to set.
       * @return This builder for chaining.
       */
      public Builder setResortIDBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        resortID_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object seasonID_ = "";
      /**
       * <code>string seasonID = 2;</code>
       * @return The seasonID.
       */
      public java.lang.String getSeasonID() {
        java.lang.Object ref = seasonID_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          seasonID_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string seasonID = 2;</code>
       * @return The bytes for seasonID.
       */
      public com.google.protobuf.ByteString
      getSeasonIDBytes() {
        java.lang.Object ref = seasonID_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          seasonID_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string seasonID = 2;</code>
       * @param value The seasonID to set.
       * @return This builder for chaining.
       */
      public Builder setSeasonID(
          java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        seasonID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string seasonID = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearSeasonID() {

        seasonID_ = getDefaultInstance().getSeasonID();
        onChanged();
        return this;
      }
      /**
       * <code>string seasonID = 2;</code>
       * @param value The bytes for seasonID to set.
       * @return This builder for chaining.
       */
      public Builder setSeasonIDBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        seasonID_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object dayID_ = "";
      /**
       * <code>string dayID = 3;</code>
       * @return The dayID.
       */
      public java.lang.String getDayID() {
        java.lang.Object ref = dayID_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          dayID_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string dayID = 3;</code>
       * @return The bytes for dayID.
       */
      public com.google.protobuf.ByteString
      getDayIDBytes() {
        java.lang.Object ref = dayID_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          dayID_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string dayID = 3;</code>
       * @param value The dayID to set.
       * @return This builder for chaining.
       */
      public Builder setDayID(
          java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        dayID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string dayID = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDayID() {

        dayID_ = getDefaultInstance().getDayID();
        onChanged();
        return this;
      }
      /**
       * <code>string dayID = 3;</code>
       * @param value The bytes for dayID to set.
       * @return This builder for chaining.
       */
      public Builder setDayIDBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        dayID_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object skierID_ = "";
      /**
       * <code>string skierID = 4;</code>
       * @return The skierID.
       */
      public java.lang.String getSkierID() {
        java.lang.Object ref = skierID_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          skierID_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string skierID = 4;</code>
       * @return The bytes for skierID.
       */
      public com.google.protobuf.ByteString
      getSkierIDBytes() {
        java.lang.Object ref = skierID_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          skierID_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string skierID = 4;</code>
       * @param value The skierID to set.
       * @return This builder for chaining.
       */
      public Builder setSkierID(
          java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        skierID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string skierID = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearSkierID() {

        skierID_ = getDefaultInstance().getSkierID();
        onChanged();
        return this;
      }
      /**
       * <code>string skierID = 4;</code>
       * @param value The bytes for skierID to set.
       * @return This builder for chaining.
       */
      public Builder setSkierIDBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        skierID_ = value;
        onChanged();
        return this;
      }

      private int time_ ;
      /**
       * <code>int32 time = 5;</code>
       * @return The time.
       */
      @java.lang.Override
      public int getTime() {
        return time_;
      }
      /**
       * <code>int32 time = 5;</code>
       * @param value The time to set.
       * @return This builder for chaining.
       */
      public Builder setTime(int value) {

        time_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 time = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearTime() {

        time_ = 0;
        onChanged();
        return this;
      }

      private int liftID_ ;
      /**
       * <code>int32 liftID = 6;</code>
       * @return The liftID.
       */
      @java.lang.Override
      public int getLiftID() {
        return liftID_;
      }
      /**
       * <code>int32 liftID = 6;</code>
       * @param value The liftID to set.
       * @return This builder for chaining.
       */
      public Builder setLiftID(int value) {

        liftID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 liftID = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearLiftID() {

        liftID_ = 0;
        onChanged();
        return this;
      }

      private int waitTime_ ;
      /**
       * <code>int32 waitTime = 7;</code>
       * @return The waitTime.
       */
      @java.lang.Override
      public int getWaitTime() {
        return waitTime_;
      }
      /**
       * <code>int32 waitTime = 7;</code>
       * @param value The waitTime to set.
       * @return This builder for chaining.
       */
      public Builder setWaitTime(int value) {

        waitTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 waitTime = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearWaitTime() {

        waitTime_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:SkiDayVertical)
    }

    // @@protoc_insertion_point(class_scope:SkiDayVertical)
    private static final SkiDayVerticalOuterClass.SkiDayVertical DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new SkiDayVerticalOuterClass.SkiDayVertical();
    }

    public static SkiDayVerticalOuterClass.SkiDayVertical getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SkiDayVertical>
        PARSER = new com.google.protobuf.AbstractParser<SkiDayVertical>() {
      @java.lang.Override
      public SkiDayVertical parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SkiDayVertical(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SkiDayVertical> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SkiDayVertical> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public SkiDayVerticalOuterClass.SkiDayVertical getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
      internal_static_SkiDayVertical_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SkiDayVertical_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
  getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
        "\n\024SkiDayVertical.proto\"\204\001\n\016SkiDayVertica" +
            "l\022\020\n\010resortID\030\001 \001(\t\022\020\n\010seasonID\030\002 \001(\t\022\r\n" +
            "\005dayID\030\003 \001(\t\022\017\n\007skierID\030\004 \001(\t\022\014\n\004time\030\005 " +
            "\001(\005\022\016\n\006liftID\030\006 \001(\005\022\020\n\010waitTime\030\007 \001(\005b\006p" +
            "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
        .internalBuildGeneratedFileFrom(descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
            });
    internal_static_SkiDayVertical_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_SkiDayVertical_fieldAccessorTable = new
        com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SkiDayVertical_descriptor,
        new java.lang.String[] { "ResortID", "SeasonID", "DayID", "SkierID", "Time", "LiftID", "WaitTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
