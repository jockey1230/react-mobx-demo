import React, {Component} from 'react';
import {Button, Row} from 'antd';
import {observer} from "mobx-react"
import {modelsStore} from "./store/models"
import './App.css';

@observer
class App extends Component {

    componentDidMount() {
        modelsStore.load()
    }

    render() {
        const models = modelsStore.models;
        const selectedModel = modelsStore.selectedModel;
        const selectedFeatures = modelsStore.selectedFeatures;
        const packages = modelsStore.packages;
        return (
            <div className="App">
                {
                    selectedModel.features && selectedModel.features.map((feature, idx) =>
                        <Row key={idx} className="btn-group">
                            <Button type="primary">{feature.name}</Button>
                            {
                                feature.options.map((option, _idx) =>
                                    <Button type={selectedFeatures[feature.name] === option.code ? "dashed" : ""}
                                            onClick={() => modelsStore.doSelectFeature(feature.name, option.code)}
                                            key={_idx}>{option.code}</Button>
                                )
                            }
                        </Row>
                    )
                }
                <Row className="btn-group">
                    <Button type="primary">PACKAGES</Button>
                    {
                        packages ? packages.map((_package, idx) =>
                            <Button key={idx} onClick={() => modelsStore.doSelectPackage(_package)}
                                    type={_package.selected ? "dashed" : ""}>{_package.name}</Button>
                        ) : ""
                    }
                </Row>
                {
                    models.map((model, idx) =>
                        <Button key={idx} type={model.name === selectedModel.name ? "primary" : ""}
                                onClick={() => modelsStore.doSelectModel(idx)}>{model.name}</Button>
                    )
                }
                <Row>
                    {JSON.stringify(selectedFeatures)}
                </Row>
            </div>
        );
    }
}

export default App;
