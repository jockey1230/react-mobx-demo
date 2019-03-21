import {action, observable} from "mobx"
import axios from 'axios'

class ModelsStore {

    models = [];

    @observable selectedModel = {}

    @observable selectedFeatures = {}

    @observable packages = []

    @action.bound load() {
        axios.get('/models')
            .then(response => {
                this.models = response.data
                this.selectedModel = this.models[0]
                this.init()
            })
            .catch(error => console.log(error));
    }

    @action.bound doSelectModel(index) {
        this.selectedModel = this.models[index]
        this.init()
    }

    @action.bound doSelectFeature(name, code) {
        this.selectedFeatures[name] = code

        this.packages && this.packages
            .filter(_package => _package.selected && _package.features[name] && _package.features[name] !== code)
            .forEach(_package => _package.selected = false)
    }

    @action.bound doSelectPackage(_package) {
        if (_package.def) {
            return
        }

        _package.selected = !_package.selected

        if (_package.selected) {
            this.selectedFeatures = Object.assign(this.selectedFeatures, _package.features)
        }
    }

    @action.bound init() {
        this.selectedFeatures = {}
        this.packages = this.selectedModel.packages

        this.selectedModel.features.forEach(feature => {
            feature.options.forEach(option => {
                option.def && (this.selectedFeatures[feature.name] = option.code)
            })
        })

        this.packages && this.packages.filter(_package => _package.def).forEach(_package => {
            this.selectedFeatures = Object.assign(this.selectedFeatures, _package.features)
            _package.selected = true
        })
    }

}

export const modelsStore = new ModelsStore()