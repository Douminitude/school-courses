<template>
    <form @submit.prevent="sendForm" class="weekForm">
        <div class="formGroup">

            <label    for="semaine">Semaine</label>
            <input    class="formInput" id="semaine"   name="semaine"   placeholder="Add Week"    v-model="semaine" type="text"    ref="semaine"/>
        
        </div>
        <div class="formGroup">

            <label    for="subject">Sujet</label>
            <textarea class="formInput" id="subject"   name="subject"   placeholder="Add Subject" v-model="subject"   ></textarea>
        
        </div>
        <div class="formGroup formGroup-flexParent" >
        <div class="formGroup-flexChild">
            
            <label    for="docFiles">Document</label>
            <input    class="formInput" id="docFiles"  name="docFiles"  type="file" multiple />
        
        </div>
        <div class="formGroup-flexChild">
            
            <label    for="fileNames">Nom du document</label>
            <textarea class="formInput" id="fileNames" name="fileNames" placeholder="Add File"    v-model="fileNames"   ></textarea>
        
        </div>
        </div>
		<div class="formButton">

			<input class="submitWeekButton" type="submit" value="Save Week" />

		</div>
    </form>
</template>

<script>
    export default {
        name: 'FormWeek',
        props: {
            coursIFT:   String,
            week:       Object,
        },
        created() {
            this.$nextTick(() => this.$refs.semaine.focus())
        },
        data() {
            return {
                cours:      this.week.cours,
                semaine:    this.week.semaine,
                subject:    this.week.subject,
                fileNames:  this.week.fileNames,
            }
        },
        methods: {
            sendForm(e) {
                if (!this.semaine) {
                    alert('Please add a week')
                    return
                }

                // let namesOfFiles;
                // let fileNamesArray;
                // if (!this.fileNames) {
                //     namesOfFiles = '';
                //     fileNamesArray = [];
                // } else {
                //     namesOfFiles = this.fileNames;
                //     fileNamesArray = this.fileNames.split("\n");
                // }

                // let docsBirth = [];
                // let doc = {};
                // let fichier = e.target.docFiles;
                // let fileInput = document.getElementById('docFiles').files; 

                // if (!fichier) {
                //     e.preventDefault();
                //     alert("Nope. Failed submitting");
                // } else {
                //     for (let i = 0; i < fileInput.length; i++) {
                //         doc = {
                //             fileNameBack: fileInput[i].name,
                //             fileNameFront: fileNamesArray[i],
                //         }
                //         docsBirth.push(doc);      
                //     }      
                // }

                //     for (let i = 0; i < fileNamesArray.length; i++) {
                //         doc = {
                //             fileNameBack: this.week.docs[i].fileNameBack,
                //             fileNameFront: fileNamesArray[i],
                //         }
                //         docsBirth.push(doc);          
                //     }
                
                if (this.week.id == null) {
                    this.onSubmit(e);
                } else {
                    this.updateWeek(e);
                }
            },
            onSubmit(e) {     
                let namesOfFiles;
                let fileNamesArray;
                if (!this.fileNames) {
                    namesOfFiles = '';
                    fileNamesArray = [];
                } else {
                    namesOfFiles = this.fileNames;
                    fileNamesArray = this.fileNames.split("\n");
                }       

                let docsBirth = [];
                let doc = {};
                let fichier = e.target.docFiles;
                let fileInput = document.getElementById('docFiles').files; 

                if (!fichier) {
                    e.preventDefault();
                    alert("Nope. Failed submitting");
                } else {
                    for (let i = 0; i < fileInput.length; i++) {
                        doc = {
                            fileNameBack: fileInput[i].name,
                            fileNameFront: fileNamesArray[i],
                        }
                        docsBirth.push(doc);
                    }
                }

                // if (fileInput.length === 0) {
                //     for (let i = 0; i < fileNamesArray.length; i++) {
                //         doc = {
                //             fileNameBack: this.week.docs[i].fileNameBack,
                //             fileNameFront: fileNamesArray[i],
                //         }
                //         docsBirth.push(doc);          
                //     }
                // } else {
                //     if (!fichier) {
                //         e.preventDefault();
                //         alert("Nope. Failed submitting");
                //     } else {
                //         for (let i = 0; i < fileInput.length; i++) {
                //             doc = {
                //                 fileNameBack: fileInput[i].name,
                //                 fileNameFront: fileNamesArray[i],
                //             }
                //             docsBirth.push(doc);      
                //         }      
                //     }
                // }

                let newWeek = {
                    cours:     this.coursIFT,
                    semaine:   this.semaine,
                    subject:   this.subject,
                    docs:      docsBirth,
                    fileNames: namesOfFiles,
                    folded:    false,
                    tasks:     [],
                }
                this.$emit('addWeek', newWeek)
                this.cours = ''
                this.semaine = ''
                this.subject = ''
                this.fileNames = ''
                this.folded = false    
            },
            updateWeek(e) {   
                let namesOfFiles;
                let fileNamesArray;
                if (!this.fileNames) {
                    namesOfFiles = '';
                    fileNamesArray = [];
                } else {
                    namesOfFiles = this.fileNames;
                    fileNamesArray = this.fileNames.split("\n");
                }    

                let fichier = e.target.docFiles;
                let fileInput = document.getElementById('docFiles').files; 
                let docsBirth = [];
                let doc = {};

                if (fileInput.length === 0) {
                    for (let i = 0; i < fileNamesArray.length; i++) {
                        doc = {
                            fileNameBack: this.week.docs[i].fileNameBack,
                            fileNameFront: fileNamesArray[i],
                        }
                        docsBirth.push(doc);         
                    }
                } else {
                    if (!fichier) {
                        e.preventDefault();
                        alert("Nope. Failed submitting");
                    } else {
                        for (let i = 0; i < fileInput.length; i++) {
                            doc = {
                                fileNameBack: fileInput[i].name,
                                fileNameFront: fileNamesArray[i],
                            }
                            docsBirth.push(doc);      
                        }      
                    }
                }
                
                let editWeek = {
                    cours:     this.coursIFT,
                    semaine:   this.semaine,
                    subject:   this.subject,
                    docs:      docsBirth,
                    fileNames: namesOfFiles,
                    folded:    false,
                    id:        this.week.id,
                    tasks:     this.week.tasks
                }    

                this.$emit('updateWeek', editWeek);
                this.cours = ''
                this.semaine = ''
                this.subject = ''
                this.fileNames = ''
                this.folded = false  
            },
        }
    }
</script>

<style>
    .formGroup-flexParent {
        display: flex;
        justify-content: space-between;
    }
    .formGroup-flexChild {
        display: inline-block;
        width: 49%;
    }
    .formInput {
        display: block;
        min-height: 40px;
        height: 40px;
        width: 100%;
		margin: 20px 0;
        padding: .375rem .75rem;
        color: #212529;
        line-height: 1.5;
        white-space: pre-wrap;
        appearance: none;
        border-radius: .25rem;
        background-clip: padding-box;
        background-color: #fff;
        border: 1px solid #ced4da;
        transition: border-color .15s ease-in-out,
                    box-shadow .15s ease-in-out;
    }
    .formInput:focus {
        outline: none;
        border-color: #86b7fe;
        box-shadow: 0 0 0 .15rem rgba(13,110,253,.25);
    }
    .formInput::file-selector-button {
        padding: .5rem .75rem;
        margin: -.375rem -.75rem;
        border-width: 0;
        border-style: solid;
        border-color: inherit;
        pointer-events: none;
        background-color: #e9ecef;
        margin-inline-end: .75rem;
        border-inline-end-width: 1px;
        transition: color .15s ease-in-out,
                    box-shadow .15s ease-in-out,
                    border-color .15s ease-in-out,
                    background-color .15s ease-in-out;
    }
	.formButton {
		text-align: center;
	}
	.submitWeekButton {
		display: inline-block;
		margin: 20px auto 30px auto;
		height: 2.5rem;
		width: 8rem;
		color: #1d00db;
		background: white;
		border-radius: 5px;
		border: solid 1px #1d00db;
        transition: box-shadow 30ms linear, background-color 30ms linear;
	}
	.submitWeekButton:hover {
        background-color: #f5f5f5;
        box-shadow:  0.5px 1px 1px 1px rgba(66, 66, 66, 0.2), 
                    -0.5px 0px 1px 1px rgba(66, 66, 66, 0.2);
	}
</style>