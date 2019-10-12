<template>
  <div>
    <button id="filePicker"></button>
    <button @click="cancelUpload">取消上传</button>
    <button @click="stopUpload">暂停上传</button>
    <web-upload
      ref="uploader"
      url="http://127.0.0.1:8091/File/Upload"
      uploadButton="#filePicker"
      multiple
      @fileChange="fileChange"
      @progress="onProgress"
      @success="onSuccess"
    ></web-upload>
    <ul>
      <li v-for="(item, index) in filePercentages" :key="index">{{item}}</li>
    </ul>
  </div>
</template>

<script> 
import webUpload from '../components/web-upload.vue'
export default {
  name: 'File',
  data: () => {
    return {
      uploadingFile: null,
      filePercentages: []
    }
  },
  components: {
    webUpload: webUpload
  },
  methods: {
    cancelUpload() {
      let _this = this
      if (_this.uploadingFile != null)
        _this.$refs['uploader'].cancelFile(_this.uploadingFile.id);
    },
    stopUpload() {
      let _this = this
      if (_this.uploadingFile != null)
        _this.$refs['uploader'].stop(_this.uploadingFile.id);
    },
    fileChange(file) {
      let _this = this
      _this.uploadingFile = file
      _this.filePercentages = []
    },
    onProgress(file, percentage) {
      let _this = this
      _this.filePercentages.unshift((percentage * 100).toFixed(20) + '%')
    },
    onSuccess(file, response) {
      debugger

    }
  }
}
</script>
